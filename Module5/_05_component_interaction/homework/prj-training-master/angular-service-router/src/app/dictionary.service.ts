import { Injectable } from '@angular/core';

export interface IWord {
  key: string;
  meaning: string;
}

@Injectable()
export class DictionaryService {
  private words: IWord[] = [
    {
      key: 'service',
      meaning: 'dịch vụ'
    }, {
      key: 'service provider',
      meaning: 'nhà cung cấp dịch vụ'
    }, {
      key: 'provide',
      meaning: 'cung cấp'
    }, {
      key: 'efficient',
      meaning: 'hiệu quả'
    }, {
      key: 'snow',
      meaning: 'tuyết'
    }
  ];
  constructor() { }

  search(word: string): string {
    if (!word) {
      return '';
    }
    const w = this.words.find(item => item.key === word.toLowerCase());
    if (w) {
      return w.meaning;
    }
    return 'Not found';
  }

  getAll(): IWord[] {
    return this.words;
  }
}
