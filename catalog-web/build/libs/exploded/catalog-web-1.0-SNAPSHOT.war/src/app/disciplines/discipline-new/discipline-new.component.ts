import {Component} from "@angular/core";
import {Location} from "@angular/common";
import {DisciplineService} from "../shared/discipline.service";

@Component({
  moduleId: module.id,
  selector: 'ubb-discipline-new',
  templateUrl: './discipline-new.component.html',
  styleUrls: ['./discipline-new.component.css'],
})
export class DisciplineNewComponent {

  constructor(private location: Location,
              private disciplineService: DisciplineService) {

  }

  goBack(): void {
    console.log("mesaj");

    this.location.back();
  }

  save(title, teacher, labNumber) {
    console.log("saveNewDiscipline");

    this.disciplineService.save(title, teacher, labNumber)
      .subscribe(discipline => {
        console.log("discipline saved");
        this.location.back();
      });

  }
}
