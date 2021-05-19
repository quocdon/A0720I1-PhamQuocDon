import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from '../student';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  @Input()
  student: IStudent;

  @Output()
  changeGrade: EventEmitter<IStudent> = new EventEmitter<IStudent>();

  constructor() { }

  ngOnInit(): void {
  }

  updateGrade(newGrade: any) {
    this.student.grade = newGrade.value;
    this.changeGrade.emit(this.student);
  }
}
