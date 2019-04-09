import {Component, OnInit} from '@angular/core';
import {Student} from "../shared/student.model";
import {StudentService} from "../shared/student.service";
import {Router} from "@angular/router";
import {_finally} from "rxjs/operator/finally";
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/finally';




@Component({
  moduleId: module.id,
  selector: 'ubb-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent implements OnInit {
  errorMessage: string;
  students: Array<Student>;
  selectedStudent: Student;
  error: string = "";

  constructor(private studentService: StudentService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getStudents();
  }

  getStudents() {
    this.studentService.getStudents()
      .subscribe(
        students => this.students = students,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(student: Student): void {
    this.selectedStudent = student;
  }

  gotoDetail(): void {
    this.router.navigate(['/student/detail', this.selectedStudent.id]);
  }

  delete(): void {
    if (confirm("Are you sure?")) {

      this.studentService.delete(this.selectedStudent.id)
        .subscribe(result => {
            console.log("Student was deleted" + result);
            window.location.reload();
          },
          error => {
            this.errorMessage = <any>error;
            this.error = "A aparut o eroare!";
          });
    }
  }

  // enroll(): void {
  //   this.router.navigate(['/student/marks', this.selectedStudent.id]);
  // }
}

