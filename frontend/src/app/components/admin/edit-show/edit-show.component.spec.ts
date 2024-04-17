import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditShowComponent } from './edit-show.component';

describe('EditShowComponent', () => {
  let component: EditShowComponent;
  let fixture: ComponentFixture<EditShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditShowComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
