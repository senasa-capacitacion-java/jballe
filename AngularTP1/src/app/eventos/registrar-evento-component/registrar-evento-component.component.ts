import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Evento } from 'src/app/modelos/evento';
import { EventosServicio } from 'src/app/servicios/eventos-servicio';

@Component({
  selector: 'app-registrar-evento-component',
  templateUrl: './registrar-evento-component.component.html',
  styleUrls: ['./registrar-evento-component.component.css']
})
export class RegistrarEventoComponentComponent implements OnInit {

  submitted = false
  modelEvent: Evento
  mostrarForm: boolean = false;

  constructor() {
    this.modelEvent = new Evento("","","");
  }

  ngOnInit(): void {
  }

  onSubmit(){
    EventosServicio.eventos.push(this.modelEvent)
    this.mostrarForm = false;
  }

  cambiarMostrarForm(){
    this.mostrarForm = !this.mostrarForm
  }
  get diagnostic(){
    return JSON.stringify(this.modelEvent)
  }
}
