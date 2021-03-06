"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var http_1 = require('@angular/http');
var Observable_1 = require('rxjs/Observable');
require('rxjs/Rx');
var EventService = (function () {
    function EventService(http) {
        this.http = http;
        this.heroesUrl = 'http://localhost:8080/rest/events'; // URL to web api
        this.heroeUrl = 'http://localhost:8080/rest/event/'; // URL to web api
        this.eventAttendStat = 'http://localhost:8080/rest/event/attend/stat'; // URL to web api
        this.eventMaxPriceURL = 'http://localhost:8080/rest/event/max/city';
        this.eventCatMaxStatURL = 'http://localhost:8080/rest/event/max/cat';
        this.usersActivityDTOURL = 'http://localhost:8080/rest/user/actives';
        this.search = 'http://localhost:8080/rest/event/search';
        this.full_search = 'http://localhost:8080/rest/search/';
    }
    EventService.prototype.getEvents = function () {
        return this.http.get(this.heroesUrl)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.extractData = function (res) {
        var body = res.json();
        console.error(body);
        return body || {};
    };
    EventService.prototype.handleError = function (error) {
        // In a real world app, we might use a remote logging infrastructure
        var errMsg;
        if (error instanceof http_1.Response) {
            var body = error.json() || '';
            var err = body.error || JSON.stringify(body);
            errMsg = error.status + " - " + (error.statusText || '') + " " + err;
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable_1.Observable.throw(errMsg);
    };
    EventService.prototype.getEvent = function (id) {
        return this.http.get(this.heroeUrl + "" + id)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.getEventUsers = function (id) {
        return this.http.get(this.heroeUrl + "" + id + "/users/")
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.getEventStatAttendStat = function () {
        return this.http.get(this.eventAttendStat)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.getEventMaxPriceCityDTO = function () {
        return this.http.get(this.eventMaxPriceURL)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.getEventCatMaxStat = function () {
        return this.http.get(this.eventCatMaxStatURL)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.getUsersActivityDTO = function () {
        return this.http.get(this.usersActivityDTOURL)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.getSearch = function (title, city, price) {
        return this.http.get(this.search + "/" + title + "/" + city + "/" + price)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService.prototype.getFullSearch = function (search) {
        return this.http.get(this.full_search + search)
            .map(this.extractData)
            .catch(this.handleError);
    };
    EventService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], EventService);
    return EventService;
}());
exports.EventService = EventService;
//# sourceMappingURL=event.service.js.map