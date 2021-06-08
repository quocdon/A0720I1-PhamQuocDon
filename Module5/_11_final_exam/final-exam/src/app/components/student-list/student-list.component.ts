import {Component, OnInit} from '@angular/core';
import {StudentService} from '../../services/student.service';
import {Student} from '../../models/student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {
  page = 1;
  students: Student[];
  selectedStudent: Student = {
    email: '',
    groupName: '',
    id: 0,
    name: '',
    phone: '',
    teacher: null,
    topic: '',
  };

  constructor(private studentService: StudentService) {
  }

  ngOnInit(): void {
    this.studentService.getAllStudents().subscribe(
      data => this.students = data
    );
  }

  getStudent(student: Student) {
    this.selectedStudent = student;
  }

  deleteStudent(id) {
    this.studentService.deleteStudent(id).subscribe(
      data => this.ngOnInit()
    );
  }
}
