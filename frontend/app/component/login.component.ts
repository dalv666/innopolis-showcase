import { Event } from './../model/event';
import { EventService } from './../service/event.service';
import { UserService } from './../service/user.service';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Location } from '@angular/common';
import { Http } from '@angular/http';
import { contentHeaders } from './../common/headers';

@Component({
    moduleId: module.id,
    templateUrl: './../view/login.component.html'
})

export class LoginComponent {

    constructor(public router: Router, public http: Http) {
    }

    login(event, username, password) {
        event.preventDefault();
        let body = JSON.stringify({ username, password });
        this.http.post('http://localhost:8080/rest/sessions/create', body, { headers: contentHeaders })
            .subscribe(
            response => {
                localStorage.setItem('id_token', response.json().id_token);
                this.router.navigate(['events']);
            },
            error => {
                alert(error.text());
                console.log(error.text());
            }
            );
    }

    signup(event) {
        event.preventDefault();
        this.router.navigate(['signup']);
    }


}
