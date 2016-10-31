import { Event } from './../model/event';
import { User } from './../model/models';
import { EventService } from './../service/event.service';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

@Component({
    selector: "event-detail",
    moduleId:module.id,
    templateUrl: './../view/event-detail.component.html',
    providers: [EventService]
})

export class EventDetailComponent implements OnInit {
  event: Event;
  users: User[];
  errorMessage:string;
  goBack(): void {
    this.location.back();
  }

  ngOnInit():void{
    this.route.params.forEach((params: Params) => {
    let id = +params['id'];
      this.eventService.getEvent(id)
                           .subscribe(
                             event => this.event = event,
                             error =>  this.errorMessage = <any>error);
  });

  this.route.params.forEach((params: Params) => {
  let id = +params['id'];
  this.eventService.getEventUsers(id)
                         .subscribe(
                           users => this.users = users,
                           error =>  this.errorMessage = <any>error);
});


  }


  constructor(
    private eventService:EventService ,
    private route:ActivatedRoute,
    private location:Location
  ){}

}
