package com.prueba.proyectointerciclop67backend.controller;

import com.prueba.proyectointerciclop67backend.dto.ReservaAsesoriaRequest;
import com.prueba.proyectointerciclop67backend.exception.ResourceNotFoundException;
import com.prueba.proyectointerciclop67backend.model.Asesoria;
import com.prueba.proyectointerciclop67backend.model.HoraAsesoria;
import com.prueba.proyectointerciclop67backend.model.ReservaAsesoria;
import com.prueba.proyectointerciclop67backend.model.Usuario;
import com.prueba.proyectointerciclop67backend.repository.AsesoriaRepository;
import com.prueba.proyectointerciclop67backend.repository.HoraAsesoriaRepository;
import com.prueba.proyectointerciclop67backend.repository.ReservaAsesoriaRepository;
import com.prueba.proyectointerciclop67backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaAsesoriaController {
    @Autowired
    private ReservaAsesoriaRepository reservaAsesoriaRepository;
    @Autowired
    private AsesoriaRepository asesoriaRepository;
    @Autowired
    private HoraAsesoriaRepository horaAsesoriaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<ReservaAsesoria> getAll (){
        return reservaAsesoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaAsesoria> getReservaById(@PathVariable Integer id){
        ReservaAsesoria reserva=reservaAsesoriaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se encontro la asesoria con id: "+id));
        return ResponseEntity.ok(reserva);
    }
    @PostMapping
    public ResponseEntity<ReservaAsesoria> crearReservaAsesoria(@RequestBody ReservaAsesoriaRequest request){
        Asesoria asesoria = asesoriaRepository.findById(request.getIdAsesoria()).orElseThrow(()->new ResourceNotFoundException("No se encontro la asesoria con el Id: " + request.getIdAsesoria()));
        HoraAsesoria hora=horaAsesoriaRepository.findById(request.getIdHoraAsesoria()).orElseThrow(()->new ResourceNotFoundException("No se encotro la hora con el Id: "+request.getIdHoraAsesoria()));
        Usuario solicitante= usuarioRepository.findById(request.getIdSolicitante()).orElseThrow(()->new ResourceNotFoundException("No se encontro el usuario solicitante con el Id: "+request.getIdSolicitante()));
        Usuario programador=usuarioRepository.findById(request.getIdProgramador()).orElseThrow(()->new ResourceNotFoundException("No se encontro el Programador con el Id: "+request.getIdProgramador()));
        ReservaAsesoria reservaAsesoria=
                new ReservaAsesoria(
                        request.getMotivo(),
                        asesoria,
                        hora,
                        solicitante,
                        programador,
                        request.getEstado()
                );
        ReservaAsesoria guardarReserva=reservaAsesoriaRepository.save(reservaAsesoria);
        return ResponseEntity.ok(guardarReserva);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<ReservaAsesoria> eliminar(@PathVariable Integer id){
        if (!reservaAsesoriaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        reservaAsesoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReservaAsesoria> actualizarReserva(@PathVariable Integer id, @RequestBody ReservaAsesoriaRequest request){
        ReservaAsesoria datosReserva=reservaAsesoriaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se encontro la Reserva con el Id: "+id));
        if(request.getMotivo()!=null){
            datosReserva.setMotivo(request.getMotivo());
        }
        if(request.getEstado()!=null){
            datosReserva.setEstado(request.getEstado());
        }
        ReservaAsesoria reservaActualizada=reservaAsesoriaRepository.save(datosReserva);
        return ResponseEntity.ok(reservaActualizada);
    }
}
