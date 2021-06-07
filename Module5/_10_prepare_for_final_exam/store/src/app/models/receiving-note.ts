import {Item} from './item';

export interface ReceivingNote {
  id: number;
  item: Item;
  quantity: number;
  price: number;
  date: string;
}
