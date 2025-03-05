import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { AppRoutingModule } from './app/app-routing.module';
import { CoreModule } from './app/core/core.module';
import { SharedModule } from './app/core/shared/shared.module';

bootstrapApplication(AppComponent, {
  providers: [
    AppRoutingModule,
    CoreModule,
    SharedModule
  ]
});
