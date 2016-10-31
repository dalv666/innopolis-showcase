import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }   from './component/app.component';
import { FormsModule }   from '@angular/forms';
import { EventDetailComponent} from './component/event-detail.component';
import { LoginComponent} from './component/login.component';
import { EventsComponent} from './component/events.component';
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
  declarations: [ AppComponent, EventDetailComponent, EventsComponent, MenuComponent, LoginComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
