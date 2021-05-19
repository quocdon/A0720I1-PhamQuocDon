import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IArticle} from '../hackernews-model/iArticle';

@Component({
  selector: 'app-hackernews-create',
  templateUrl: './hackernews-create.component.html',
  styleUrls: ['./hackernews-create.component.scss']
})
export class HackernewsCreateComponent implements OnInit {
  newArticle: IArticle = {
    id: 0,
    title: '',
    url: '',
    likes: 0
  };
  @Input()
  message = '';
  @Output()
  saveNewArticle: EventEmitter<IArticle> = new EventEmitter<IArticle>();

  constructor() { }

  ngOnInit(): void {
  }

  save(title: any, url: any) {
    if (title.value !== '' && url.value !== ''){
      this.newArticle.title = title.value;
      this.newArticle.url = url.value;
      this.saveNewArticle.emit(this.newArticle);
    }
  }
}
