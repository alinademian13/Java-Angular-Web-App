import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {StudentsComponent} from "./students/students.component";
import {StudentDetailComponent} from "./students/student-detail/student-detail.component";
import {StudentNewComponent} from "./students/student-new/student-new.component";

import {DisciplinesComponent} from "./disciplines/disciplines.component";
import {DisciplineNewComponent} from "./disciplines/discipline-new/discipline-new.component";
import {DisciplineDetailComponent} from "./disciplines/discipline-detail/discipline-detail.component";

import {MarksComponent} from "./marks/marks.component";


const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'students', component: StudentsComponent},
  {path: 'student/detail/:id', component: StudentDetailComponent},
  {path: 'student-new', component: StudentNewComponent},

  {path: 'disciplines', component: DisciplinesComponent},
  {path: 'discipline/detail/:id', component: DisciplineDetailComponent},
  {path: 'discipline-new', component: DisciplineNewComponent},

  {path: 'marks', component: MarksComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
