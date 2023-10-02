import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ScoreViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    companion object {
        private const val SCORE_TEAM_A_KEY = "SCORE_TEAM_A_KEY"
        private const val SCORE_TEAM_B_KEY = "SCORE_TEAM_B_KEY"
    }

    init {
        if (!savedStateHandle.contains(SCORE_TEAM_A_KEY)) {
            savedStateHandle.set(SCORE_TEAM_A_KEY, 0)
        }
        if (!savedStateHandle.contains(SCORE_TEAM_B_KEY)) {
            savedStateHandle.set(SCORE_TEAM_B_KEY, 0)
        }
    }

    var scoreTeamA: Int
        get() = savedStateHandle.get(SCORE_TEAM_A_KEY) ?: 0
        set(value) = savedStateHandle.set(SCORE_TEAM_A_KEY, value)

    var scoreTeamB: Int
        get() = savedStateHandle.get(SCORE_TEAM_B_KEY) ?: 0
        set(value) = savedStateHandle.set(SCORE_TEAM_B_KEY, value)

    fun resetScores() {
        scoreTeamA = 0
        scoreTeamB = 0
    }

    fun addScoreTeamA(points: Int) {
        scoreTeamA += points
    }

    fun addScoreTeamB(points: Int) {
        scoreTeamB += points
    }
}
