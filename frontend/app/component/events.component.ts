import { Component } from '@angular/core';
import {EventDetailComponent} from './event-detail.component';
import {Event} from './../model/event';
import {EventService} from './../service/event.service';
import { OnInit,OnDestroy } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'events',
    moduleId: module.id,
    templateUrl: './../view/events.component.html',
    styles: [`
      .selected{
        background-color: #CFD8DC !important;
        color: white;
      }

      .events:hover{
        background-color: red;
        cursor:pointer;
      }

      `],
      providers: [EventService]
})
export class EventsComponent implements OnInit{
    errorMessage:string;
    events: Event[];

    ngOnInit(): void {
      this.getEvents();
    }



    selectedEvent: Event;
    constructor(
      private eventService:EventService,
      private router:Router
    ) { }


    getEvents():void {
      this.eventService.getEvents()
                           .subscribe(
                             events => this.events = events,
                             error =>  this.errorMessage = <any>error);

    }

    onSelect(event:Event):void {
      this.selectedEvent = event;
    }

    gotoDetail(event:Event):void{
      let link = ['/event', event.id];
      this.router.navigate(link);
    }

}
