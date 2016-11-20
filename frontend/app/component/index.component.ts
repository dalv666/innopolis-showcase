import { Component } from '@angular/core';
import {EventDetailComponent} from './event-detail.component';
import {Event} from './../model/event';
import {EventService} from './../service/event.service';
import { OnInit,OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import {EventStat, EventCityMaxStat,EventCatMaxStat,UsersActivityDTO} from './../model/models';

@Component({
    selector: 'index',
    moduleId: module.id,
    templateUrl: './../view/index.component.html',
      providers: [EventService]
})
export class IndexComponent implements OnInit{
    errorMessage:string;
    events: Event[];
    eventsStats: EventStat[];
    eventCityMaxStat: EventCityMaxStat[];
    eventCatMaxStat:EventCatMaxStat[];
    usersActivity:UsersActivityDTO[];

    ngOnInit(): void {
      this.getEvents();
      this.getEventsStat();
      this.getEventCityMaxStat();
      this.getEventCatMaxStat();
      this.getUsersActivityDTO();
    }

    selectedEvent: Event;
    constructor(
      private eventService:EventService,
      private router:Router
    ) { }


    getEvents():void {
      this.eventService.getEvents()
                           .subscribe(
                             events => this.events = [events[0],events[1],events[2]],
                             error =>  this.errorMessage = <any>error);
    }

    getEventsStat():void {
      this.eventService.getEventStatAttendStat()
                           .subscribe(
                             eventsStats => this.eventsStats = eventsStats,
                             error =>  this.errorMessage = <any>error);

    }

    getEventCityMaxStat():void {
      this.eventService.getEventMaxPriceCityDTO()
                           .subscribe(
                             eventCityMaxStat => this.eventCityMaxStat = eventCityMaxStat,
                             error =>  this.errorMessage = <any>error);

    }

    getEventCatMaxStat():void {
      this.eventService.getEventCatMaxStat()
                           .subscribe(
                             eventCatMaxStat => this.eventCatMaxStat = eventCatMaxStat,
                             error =>  this.errorMessage = <any>error);

    }

    getUsersActivityDTO():void {
      this.eventService.getUsersActivityDTO()
                           .subscribe(
                             usersActivity => this.usersActivity = usersActivity,
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
