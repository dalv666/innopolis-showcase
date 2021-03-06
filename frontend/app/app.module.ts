import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }   from './component/app.component';
import { FormsModule }   from '@angular/forms';
import { EventDetailComponent} from './component/event-detail.component';
import { PersonDetailComponent} from './component/person-detail.component';
import { CityDetailComponent} from './component/city-detail.component';
import { LocationDetailComponent} from './component/location-detail.component';
import { LoginComponent} from './component/login.component';
import { EventsComponent} from './component/events.component';
import { SearchComponent } from './component/search.component';
import { FullSearchComponent } from './component/full-search.component';


import { IndexComponent } from './component/index.component';
import { RouterModule }   from '@angular/router';
import { MenuComponent} from './component/menu.component';
import { ShowcaseRoutingModule } from './showcase-routing.module';
import { HttpModule }    from '@angular/http';


@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    ShowcaseRoutingModule,
    HttpModule
   ],
  declarations: [ AppComponent, EventDetailComponent,LocationDetailComponent,FullSearchComponent,PersonDetailComponent, CityDetailComponent, EventsComponent, MenuComponent, LoginComponent,SearchComponent ,IndexComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
