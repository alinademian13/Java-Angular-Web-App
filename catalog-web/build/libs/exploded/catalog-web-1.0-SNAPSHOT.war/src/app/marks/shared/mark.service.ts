import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {Mark} from "./mark.model";
import {Student} from "../../students/shared/student.model";

@Injectable()
export class MarkService {
  private marksUrl = 'http://localhost:8080/api/marks';
  private students

  constructor(private httpClient: HttpClient) {
  }

  // getStudents(): Observable<Student[]> {
  //   return this.httpClient
  //     .get<Array<Student>>(this.stu)
  // }
}
