package com.codegym.repository.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CommentRepositoryImpl implements CommentRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.id=:id", Comment.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Comment comment) {
        em.persist(comment);
    }

    @Override
    public void like(long id) {
        Comment comment = this.findById(id);
        comment.setLike(comment.getLike() + 1);
    }
}
