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
var router_1 = require('@angular/router');
var events_component_1 = require('./component/events.component');
var index_component_1 = require('./component/index.component');
var search_component_1 = require('./component/search.component');
var event_detail_component_1 = require('./component/event-detail.component');
var city_detail_component_1 = require('./component/city-detail.component');
var location_detail_component_1 = require('./component/location-detail.component');
var menu_component_1 = require('./component/menu.component');
var login_component_1 = require('./component/login.component');
var person_detail_component_1 = require('./component/person-detail.component');
var routes = [
    {
        path: '',
        redirectTo: '/index',
        pathMatch: 'full'
    },
    {
        path: 'index',
        component: index_component_1.IndexComponent
    },
    {
        path: 'events',
        component: events_component_1.EventsComponent
    },
    {
        path: 'menu',
        component: menu_component_1.MenuComponent
    },
    {
        path: 'search',
        component: search_component_1.SearchComponent
    },
    {
        path: 'event/:id',
        component: event_detail_component_1.EventDetailComponent
    },
    {
        path: 'city/:id',
        component: city_detail_component_1.CityDetailComponent
    },
    {
        path: 'location/:id',
        component: location_detail_component_1.LocationDetailComponent
    },
    {
        path: 'person/:id',
        component: person_detail_component_1.PersonDetailComponent
    },
    {
        path: 'login',
        component: login_component_1.LoginComponent
    }
];
var ShowcaseRoutingModule = (function () {
    function ShowcaseRoutingModule() {
    }
    ShowcaseRoutingModule = __decorate([
        core_1.NgModule({
            imports: [router_1.RouterModule.forRoot(routes)],
            exports: [router_1.RouterModule],
        }), 
        __metadata('design:paramtypes', [])
    ], ShowcaseRoutingModule);
    return ShowcaseRoutingModule;
}());
exports.ShowcaseRoutingModule = ShowcaseRoutingModule;
//# sourceMappingURL=showcase-routing.module.js.map