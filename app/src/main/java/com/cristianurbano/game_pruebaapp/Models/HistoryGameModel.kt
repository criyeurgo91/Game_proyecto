package com.cristianurbano.game_pruebaapp.Models

data class HistoryGameModel(
    var id: Int? = null,
    var nameGame: String? = null,
    var idTeamWinner: String? = null,
    var idTeamLoser: String? = null,
    var pointsWinner: String? = null,
    var pointsLoser: String? = null,
)
