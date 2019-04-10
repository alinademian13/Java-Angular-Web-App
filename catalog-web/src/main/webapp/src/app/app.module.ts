import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";

import {StudentsComponent} from "./students/students.component";
import {StudentService} from "./students/shared/student.service";
import {StudentListComponent} from "./students/student-list/student-list.component";
import {StudentNewComponent} from "./students/student-new/student-new.component";
import {StudentDetailComponent} from "./students/student-detail/student-detail.component";

import {DisciplinesComponent} from "./disciplines/disciplines.component";
import {DisciplineService} from "./disciplines/shared/discipline.service";
import {DisciplineListComponent} from "./disciplines/discipline-list/discipline-list.component";
import {DisciplineNewComponent} from "./disciplines/discipline-new/discipline-new.component";
import {DisciplineDetailComponent} from "./disciplines/discipline-detail/discipline-detail.component";

import {MarksComponent} from "./marks/marks.component";
import {MarkService} from "./marks/shared/mark.service";



@NgModule({
  declarations: [
    AppComponent,
    StudentDetailComponent,
    StudentsComponent,
    StudentListComponent,
    StudentNewComponent,

    DisciplinesComponent,
    DisciplineListComponent,
    DisciplineNewComponent,
    DisciplineDetailComponent,

    MarksComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [StudentService, DisciplineService, MarkService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
