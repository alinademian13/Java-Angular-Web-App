import {Component} from '@angular/core';
import {MarkService} from "./shared/mark.service";
import {Mark} from "./shared/mark.model";
import {Location} from "@angular/common";
import {StudentService} from "../students/shared/student.service";
import {Student} from "../students/shared/student.model";
import {Discipline} from "../disciplines/shared/discipline.model";
import {DisciplineService} from "../disciplines/shared/discipline.service";


@Component({
  moduleId: module.id,
  selector: 'ubb-marks',
  templateUrl: './marks.component.html',
  styleUrls: ['./marks.component.css'],
})

export class MarksComponent {
  errorMessage: string;
  showDisciplines: boolean;
  availableStudents: Student[];

  constructor(private markService: MarkService,
              private studentService: StudentService,
              private disciplineService: DisciplineService,
              private location: Location) {
  }

  loadStudents() {
    this.showDisciplines = false;
    this.loadAvailableStudents();
  }

  private loadAvailableStudents() {
    this.studentService.getStudents()
      .subscribe(students => this.availableStudents = students,
                  error => this.errorMessage = <any>error);
  }
}




