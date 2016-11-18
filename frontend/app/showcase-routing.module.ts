import { NgModule }      from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { EventsComponent } from './component/events.component';
import { SearchComponent } from './component/search.component';
import { EventDetailComponent} from './component/event-detail.component';
import { CityDetailComponent} from './component/city-detail.component';
import { LocationDetailComponent} from './component/location-detail.component';
import { AppComponent } from './component/app.component';
import { MenuComponent} from './component/menu.component';
import { LoginComponent} from './component/login.component';
import { PersonDetailComponent} from './component/person-detail.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/events',
    pathMatch: 'full'
  },
  {
    path: 'events',
    component: EventsComponent
  },
  {
    path: 'menu',
    component: MenuComponent
  },
  {
      path: 'search',
      component: SearchComponent
  },
  {
    path: 'event/:id',
    component: EventDetailComponent
  },
  {
    path: 'city/:id',
    component: CityDetailComponent
  },
  {
    path: 'location/:id',
    component: LocationDetailComponent
  },
  {
    path: 'person/:id',
    component: PersonDetailComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class ShowcaseRoutingModule{

}
