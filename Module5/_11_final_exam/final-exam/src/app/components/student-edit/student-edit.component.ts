import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Student} from '../../models/student';
import {TeacherService} from '../../services/teacher.service';
import {StudentService} from '../../services/student.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Teacher} from '../../models/teacher';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.scss']
})
export class StudentEditComponent implements OnInit {
  teachers: Teacher[] = [];
  studentForm: FormGroup;
  student: Student;
  validationMessage = {
    'name': [
      {type: 'required', message: 'Tên sinh viên không để trống'},
      {type: 'pattern', message: 'Tên sinh viên không bao gồm ký tự đặc biệt'}
    ],
    'groupName': [
      {type: 'required', message: 'Tên nhóm không để trống'},
      {type: 'pattern', message: 'Tên nhóm không đúng định dạng'}
    ],
    'topic': [
      {type: 'required', message: 'Tên đề tài không để trống'},
    ],
    'teacher': [
      {type: 'required', message: 'Chưa chọn giáo viên hướng dẫn'},
    ],
    'phone': [
      {type: 'required', message: 'Số điện thoại không để trống'},
      {type: 'pattern', message: 'Số điện thoại có 10-12 chữ số'}
    ],
    'email': [
      {type: 'required', message: 'Email không để trống'},
      {type: 'email', message: 'Email không đúng định dạng'}
    ]
  };

  constructor(
    private teacherService: TeacherService,
    private studentService: StudentService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params["id"];
    this.teacherService.getAllTeachers().subscribe(
      data => this.teachers = data
    );
    this.initForm();
    this.studentService.getStudentById(id).subscribe(
      data => this.studentForm.patchValue(data)
    );
  }

  initForm() {
    this.studentForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^[^`|\~|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\+|\=|\[|\{|\]|\}|\||\\|\'|\<|\,|\.|\>|\?|\/|\""|\;|\:]*$/)
      ])),
      groupName: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^Nhóm [1-9][0-9]*$/),

      ])),
      topic: new FormControl('', Validators.compose([
        Validators.required
      ])),
      teacher: new FormControl('', Validators.required),
      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.email
      ])),
      phone: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/(^(\d{10,12})$)/)
      ]))
    });
  }

  onSubmit() {
    if (this.studentForm.valid) {
      this.studentService.editStudent(this.studentForm.value.id, this.studentForm.value).subscribe(data => {
        this.router.navigateByUrl('student');
      });
    }
  }

  compareWith(val1, val2) {
    return val1.id === val2.id;
  }
}
