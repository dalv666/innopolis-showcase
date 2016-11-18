import { City, User ,Person } from './../model/models';
import { PersonService } from './../service/person.service';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

@Component({
    selector: "person-detail",
    moduleId:module.id,
    templateUrl: './../view/person-detail.component.html',
    providers: [PersonService]
})

export class PersonDetailComponent implements OnInit {
  person: Person;
  errorMessage:string;
  goBack(): void {
    this.location.back();
  }

  ngOnInit():void{
    this.route.params.forEach((params: Params) => {
    let id = +params['id'];
      this.personService.getPerson(id)
                           .subscribe(
                             person => this.person = person,
                             error =>  this.errorMessage = <any>error);
  });

  }


  constructor(
    private personService:PersonService ,
    private route:ActivatedRoute,
    private location:Location
  ){}

}
