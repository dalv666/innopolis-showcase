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
var event_detail_component_1 = require('./component/event-detail.component');
var menu_component_1 = require('./component/menu.component');
var login_component_1 = require('./component/login.component');
var routes = [
    {
        path: '',
        redirectTo: '/events',
        pathMatch: 'full'
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
        path: 'event/:id',
        component: event_detail_component_1.EventDetailComponent
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