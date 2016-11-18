import { Locatione, User , Person } from './../model/models';
import { LocationService } from './../service/location.service';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

@Component({
    selector: "location-detail",
    moduleId:module.id,
    templateUrl: './../view/location-detail.component.html',
    providers: [LocationService]
})

export class LocationDetailComponent implements OnInit {
  locatione: Locatione;
  errorMessage:string;
  goBack(): void {
    this.location.back();
  }

  ngOnInit():void{
    this.route.params.forEach((params: Params) => {
    let id = +params['id'];
      this.locationService.getLocation(id)
                           .subscribe(
                             locatione => this.locatione = locatione,
                             error =>  this.errorMessage = <any>error);
  });

  }


  constructor(
    private locationService:LocationService ,
    private route:ActivatedRoute,
    private location:Location
  ){}

}
