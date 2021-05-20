import {Injectable} from '@angular/core';
import {IUser} from '../model/IUser';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private userList: IUser[] = [
    {
      email: 'admin@gmail.com',
      password: '123123',
      birthday: '01/01/1991',
      gender: 'Nam',
      country: 'Việt Nam',
      phone: '+84123123123'
    },
    {
      email: 'user1@gmail.com',
      password: '123123',
      birthday: '01/01/2001',
      gender: 'Nữ',
      country: 'Anh',
      phone: '+84123123456'
    },
    {
      email: 'user2@gmail.com',
      password: '123123',
      birthday: '01/05/2000',
      gender: 'Nam',
      country: 'Hoa kỳ',
      phone: '+84555444666'
    }];

  constructor() {
  }

  addNewUser(user: IUser){
    this.userList.push(user);
  }

  getAll(){
    return this.userList;
  }

  getByEmail(email: string){
    for (const user of this.userList){
      if (user.email === email){
        return user;
      }
    }
    return null;
  }
  login(email: string, password: string){
    if (this.getByEmail(email) != null){
      return this.getByEmail(email).password === password;
    }
    return false;
  }
}
