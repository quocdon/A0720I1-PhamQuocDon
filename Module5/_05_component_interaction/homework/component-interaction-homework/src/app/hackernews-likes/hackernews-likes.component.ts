import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IArticle} from '../hackernews-model/iArticle';

@Component({
  selector: 'app-hackernews-likes',
  templateUrl: './hackernews-likes.component.html',
  styleUrls: ['./hackernews-likes.component.scss']
})
export class HackernewsLikesComponent implements OnInit {
  @Input()
  article: IArticle;
  @Output()
  likesOnchange: EventEmitter<IArticle> = new EventEmitter<IArticle>();
  constructor() { }

  ngOnInit(): void {
  }
  likeThis() {
    this.article.likes++;
    this.likesOnchange.emit(this.article);
  }
}
