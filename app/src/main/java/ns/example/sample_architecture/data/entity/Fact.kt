package ns.example.sample_architecture.data.entity

data class CatFact (
    val all: List<Fact>
)

data class Fact (
    val text: String
)