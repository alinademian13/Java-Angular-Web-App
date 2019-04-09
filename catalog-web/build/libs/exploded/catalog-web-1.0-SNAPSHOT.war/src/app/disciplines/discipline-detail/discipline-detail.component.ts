import {Component, Input, OnInit} from '@angular/core';
import {DisciplineService} from "../shared/discipline.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from '@angular/common';
import {Discipline} from "../shared/discipline.model";

import 'rxjs/add/operator/switchMap';


@Component({
    selector: 'ubb-discipline-detail',
    templateUrl: './discipline-detail.component.html',
    styleUrls: ['./discipline-detail.component.css'],
})

export class DisciplineDetailComponent implements OnInit {

    @Input() discipline: Discipline;

    constructor(private disciplineService: DisciplineService,
                private route: ActivatedRoute,
                private location: Location) {
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.disciplineService.getDiscipline(+params['id']))
            .subscribe(discipline => this.discipline = discipline);
    }

    goBack(): void {
        this.location.back();
    }

    save(): void {
        this.disciplineService.update(this.discipline)
            .subscribe(_ => this.goBack());
    }
}
