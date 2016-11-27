import { Component } from '@angular/core';
import {EventDetailComponent} from './event-detail.component';
import {Event} from './../model/event';
import {EventService} from './../service/event.service';
import { OnInit,OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, Params }   from '@angular/router';
import {SearchRequest,EventDTO} from './../model/models';
import { Location }                 from '@angular/common';

@Component({
    selector: 'events',
    moduleId: module.id,
    templateUrl: './../view/full-search.component.html',
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
export class FullSearchComponent implements OnInit{
    errorMessage:string;
    events: EventDTO[];
    public search:string;

    ngOnInit():void{

      this.route.params.forEach((params: Params) => {
      this.search = params['search'];
        this.eventService.getFullSearch(this.search)
                             .subscribe(
                               event => this.events = event,
                               error =>  this.errorMessage = <any>error);
    });

    }

    constructor(
      private eventService:EventService ,
      private route:ActivatedRoute,
      private location:Location,
      private router:Router
    ){}


    gotoDetail(event:Event):void{
      let link = ['/event', event.id];
      this.router.navigate(link);
    }

}
