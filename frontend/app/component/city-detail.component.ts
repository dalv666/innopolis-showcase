import { City } from './../model/models';
import { User } from './../model/models';
import { CityService } from './../service/city.service';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params }   from '@angular/router';
import { Location }                 from '@angular/common';

@Component({
    selector: "city-detail",
    moduleId:module.id,
    templateUrl: './../view/city-detail.component.html',
    providers: [CityService]
})

export class CityDetailComponent implements OnInit {
  city: City;
  errorMessage:string;
  goBack(): void {
    this.location.back();
  }

  ngOnInit():void{
    this.route.params.forEach((params: Params) => {
    let id = +params['id'];
      this.cityService.getCity(id)
                           .subscribe(
                             city => this.city = city,
                             error =>  this.errorMessage = <any>error);
  });

  }


  constructor(
    private cityService:CityService ,
    private route:ActivatedRoute,
    private location:Location
  ){}

}
