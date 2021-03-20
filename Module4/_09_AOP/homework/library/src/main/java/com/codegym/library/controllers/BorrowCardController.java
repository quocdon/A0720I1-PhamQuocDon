package com.codegym.library.controllers;

import com.codegym.library.exception.BookException;
import com.codegym.library.exception.BorrowCardException;
import com.codegym.library.models.Book;
import com.codegym.library.models.BorrowCard;
import com.codegym.library.services.BookService;
import com.codegym.library.services.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BorrowCardController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowCardService borrowCardService;

    @GetMapping("/borrow/list")
    public ModelAndView borrowList() {
        return new ModelAndView("borrow/list", "borrowCards", borrowCardService.findAll());
    }

    @GetMapping("/borrow/view/{id}")
    public ModelAndView viewBorrowCard(@PathVariable int id) {
        return new ModelAndView("borrow/detail", "borrowCard", borrowCardService.findById(id));
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id, RedirectAttributes redirectAttributes) throws BookException {
        BorrowCard borrowCard = new BorrowCard();
        Book book = bookService.findById(id);
        if (book == null || book.getQty() == 0) {
            throw new BookException();
        } else {
            book.setQty(book.getQty() - 1);
            bookService.save(book);
            int borrowCardId = (int) (Math.random() * (99999 - 10000) + 10000);
            borrowCard.setId(borrowCardId);
            borrowCard.setBook(book);
            borrowCard = borrowCardService.save(borrowCard);
        }
        redirectAttributes.addFlashAttribute("message", "Mượn sách thành công");
        return "redirect:/borrow/view/" + borrowCard.getId();
    }

    @GetMapping("/return")
    public ModelAndView returnBook(@RequestParam int cardId) {
        ModelAndView modelAndView = new ModelAndView("borrow/detail");
        BorrowCard borrowCard = borrowCardService.findById(cardId);
        Book book = borrowCard.getBook();
        book.setQty(book.getQty() + 1);
        borrowCardService.delete(cardId);
        bookService.save(book);
        modelAndView.addObject("message", "Trả sách thành công");
        return modelAndView;
    }

    @GetMapping("/borrow/search")
    public ModelAndView viewSearch() {
        return new ModelAndView("/borrow/search");
    }

    @PostMapping("/borrow/search")
    public ModelAndView search(@RequestParam int cardId) throws BorrowCardException {
        ModelAndView modelAndView = new ModelAndView("borrow/detail");
        BorrowCard borrowCard = borrowCardService.findById(cardId);
        if (borrowCard == null){
            throw new BorrowCardException();
        } else {
            modelAndView.addObject("borrowCard", borrowCard);
        }
        return modelAndView;
    }

    @ExceptionHandler(BorrowCardException.class)
    public ModelAndView showErrorPage(){
        return new ModelAndView("borrow/error-page");
    }

    @ExceptionHandler(BookException.class)
    public ModelAndView showBookErrorPage(){
        return new ModelAndView("book/error-page");
    }
}
