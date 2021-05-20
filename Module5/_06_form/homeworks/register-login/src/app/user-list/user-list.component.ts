import { Component, OnInit } from '@angular/core';
import {IUser} from '../model/IUser';
import {UserServiceService} from '../services/user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  userList: IUser[];

  constructor(private userService: UserServiceService) { }

  ngOnInit(): void {
    this.userList = this.userService.getAll();
  }
}
