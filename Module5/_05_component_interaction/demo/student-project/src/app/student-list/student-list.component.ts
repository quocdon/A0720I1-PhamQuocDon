import {Component, OnInit} from '@angular/core';
import {IStudent} from '../student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  student: IStudent;
  students: IStudent[] = [
    {
      id: 1,
      name: 'Don',
      grade: 6,
    },
    {
      id: 2,
      name: 'Vu',
      grade: 8
    },
    {
      id: 3,
      name: 'Nam',
      grade: 8
    },
    {
      id: 4,
      name: 'Duy',
      grade: 8
    }
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

  view(student: IStudent) {
    this.student = student;
  }

  changeGradeHandler(updatedStudent: IStudent) {
    for (let stu of this.students){
      if (stu.id === updatedStudent.id){
        stu = updatedStudent;
      }
    }
  }
}
