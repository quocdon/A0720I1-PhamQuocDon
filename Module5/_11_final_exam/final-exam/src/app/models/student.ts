import {Teacher} from './teacher';

export interface Student {
  id: number;
  name: string;
  group: string;
  topic: string;
  teacher: Teacher;
  email: string;
  phone: string;
}
