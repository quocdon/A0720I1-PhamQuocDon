import {Component, Input, OnInit} from '@angular/core';
import {IArticle} from '../hackernews-model/iArticle';

@Component({
  selector: 'app-hackernews-list',
  templateUrl: './hackernews-list.component.html',
  styleUrls: ['./hackernews-list.component.scss']
})
export class HackernewsListComponent implements OnInit {
  @Input()
  articles: IArticle[];

  constructor() { }

  ngOnInit(): void {
  }

  updateArticle(newArticle: IArticle) {
    for (let article of this.articles){
      if (article.id === newArticle.id){
        article = newArticle;
      }
    }
  }
}
