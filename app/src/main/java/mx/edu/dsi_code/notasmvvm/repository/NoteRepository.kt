package mx.edu.dsi_code.notasmvvm.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import mx.edu.dsi_code.notasmvvm.data.NoteDatabaseDao
import mx.edu.dsi_code.notasmvvm.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao)  {
    suspend fun  addNote(note: Note) = noteDatabaseDao.insert(note)
    suspend fun updateNote(note:Note) = noteDatabaseDao.update(note)
    suspend fun  deleteNote(note:Note) = noteDatabaseDao.deleteNote(note)
    suspend fun  deleteAllNotes() = noteDatabaseDao.deleteAll()
    fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO)
        .conflate()
}