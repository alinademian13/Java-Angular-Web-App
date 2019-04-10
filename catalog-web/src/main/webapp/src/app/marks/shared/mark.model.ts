export class Mark {
  studentId: number;
  disciplineId: number;
  disciplineName: string;
  mark: number;

  constructor(studentId: number, disciplineId: number, disciplineName: string, mark: number) {
    this.studentId = studentId;
    this.disciplineId = disciplineId;
    this.disciplineName = disciplineName;
    this.mark = mark;
  }
}

