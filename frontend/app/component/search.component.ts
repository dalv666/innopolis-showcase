import { Component } from '@angular/core';
import {EventDetailComponent} from './event-detail.component';
import {Event} from './../model/event';
import {EventService} from './../service/event.service';
import { OnInit,OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import {SearchRequest,EventDTO} from './../model/models';

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
    events: EventDTO[];
    public first:boolean;
    public second:boolean;
    public third:boolean;

    public title:string;
    public city:string;
    public price:number;

    searchRequest:SearchRequest;

    ngOnInit(): void {
      this.title="Event";
      this.city="Innopolis";
      this.price=9999999;
      this.first = true;
      this.second = true;
      this.third = true;
    }



    selectedEvent: Event;
    constructor(
      private eventService:EventService,
      private router:Router
    ) { }


    onSelect(event:Event):void {
      this.selectedEvent = event;
    }

    search():void{
      this.eventService.getSearch(this.title,this.city,this.price)
                           .subscribe(
                             events => this.events = events,
                             error =>  this.errorMessage = <any>error);
      console.log(this.title);
      console.log(this.city);
      console.log(this.price);
    }

    gotoDetail(event:Event):void{
      let link = ['/event', event.id];
      this.router.navigate(link);
    }

    changeFirst(){this.first=!this.first;}
    changeSecond(){this.second=!this.second;}
    changeThird(){this.third=!this.third;}
}
