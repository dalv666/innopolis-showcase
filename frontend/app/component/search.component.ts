import { Component } from '@angular/core';
import {EventDetailComponent} from './event-detail.component';
import {Event} from './../model/event';
import {EventService} from './../service/event.service';
import { OnInit,OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import {SearchRequest} from './../model/models';

@Component({
    selector: 'events',
    moduleId: module.id,
    templateUrl: './../view/search.component.html',
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
export class SearchComponent implements OnInit{
    errorMessage:string;
    events: Event[];
    public first:boolean;
    public second:boolean;
    public third:boolean;

    searchRequest:SearchRequest;

    ngOnInit(): void {
      this.getEvents();
      this.first = true;
      this.second = true;
      this.third = true;
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

    changeFirst(){this.first=!this.first;}
    changeSecond(){this.second=!this.second;}
    changeThird(){this.third=!this.third;}
}
