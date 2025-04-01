package com.example.myjubjib

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myjubjib.databinding.AppointmentItemBinding

class AppointmentAdapter(private val appointmentList: List<Appointment>) :
    RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val binding = AppointmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppointmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val appointment = appointmentList[position]
        holder.bind(appointment)
    }

    override fun getItemCount(): Int = appointmentList.size

    class AppointmentViewHolder(private val binding: AppointmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(appointment: Appointment) {
            binding.textViewDate.text = appointment.date
            binding.textViewPurpose.text = appointment.purpose
            binding.textViewTime.text = appointment.time
            binding.textViewProfessor.text = appointment.professor
        }
    }
}
