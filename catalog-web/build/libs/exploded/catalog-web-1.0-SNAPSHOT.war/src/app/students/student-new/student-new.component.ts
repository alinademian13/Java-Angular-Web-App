import {Component} from "@angular/core";
import {Location} from "@angular/common";
import {StudentService} from "../shared/student.service";

@Component({
  moduleId: module.id,
  selector: 'ubb-student-new',
  templateUrl: './student-new.component.html',
  styleUrls: ['./student-new.component.css'],
})
export class StudentNewComponent {

  constructor(private location: Location,
              private studentService: StudentService) {

  }

  goBack(): void {
    console.log("mesaj");

    this.location.back();
  }

  save(name, groupNumber) {
    console.log("saveNewStudent");

    this.studentService.save(name, groupNumber)
      .subscribe(student => {
        console.log("student saved");
        this.location.back();
      });

  }
}
