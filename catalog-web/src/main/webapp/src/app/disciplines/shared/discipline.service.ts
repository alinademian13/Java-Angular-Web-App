import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Discipline} from "./discipline.model";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class DisciplineService {
  private disciplinesUrl = 'http://localhost:8080/api/disciplines';

  constructor(private httpClient: HttpClient) {
  }

  getDisciplines(): Observable<Discipline[]> {
    return this.httpClient
      .get<Array<Discipline>>(this.disciplinesUrl);
  }

  getDiscipline(id: number): Observable<Discipline> {
    return this.getDisciplines()
      .map(disciplines => disciplines.find(discipline => discipline.id === id));
  }

  update(discipline): Observable<Discipline> {
    const url = `${this.disciplinesUrl}/${discipline.id}`;
    return this.httpClient
      .put<Discipline>(url, discipline);
  }

  save(title, teacher, labNumber): Observable<Discipline> {
    let discipline = {title, teacher, labNumber};
    return this.httpClient
      .post<Discipline>(this.disciplinesUrl, discipline);
  }

  delete(id: number): Observable<Discipline> {
    const url = `${this.disciplinesUrl}/${id}`;
    return this.httpClient.delete<Discipline>(url);
  }

}
