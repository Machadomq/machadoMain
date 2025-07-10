use discoteca;

// QUESTÃO 1
db["nova coleção"].aggregate([
  { $group: { _id: "$artista", totalDiscos: { $sum: 1 } } }
]);

// QUESTÃO 2
db["nova coleção"].updateOne(
  { titulo: "Clube da Esquina" },
  { $set: { anoLancamento: 1972 } }
);

// QUESTÃO 3
db["nova coleção"].updateMany(
  {},
  { $unset: { numeroCatalogo: "" } }
);

// QUESTÃO 4
db["nova coleção"].aggregate([
  {
    $project: {
      titulo: 1,
      artista: 1,
      duracaoTotalMin: {
        $round: [
          { $divide: [ { $sum: "$faixas.duracao_segundos" }, 60 ] },
          1
        ]
      }
    }
  }
]);

// QUESTÃO 5
db["nova coleção"].updateOne(
  { titulo: "Elis & Tom" },
  { $addToSet: { generos: "Jazz" } }
);

// QUESTÃO 6
db["nova coleção"].aggregate([
  { $unwind: "$faixas" },
  { $match: { "faixas.compositores": "Roger Waters" } },
  {
    $project: {
      _id: 0,
      album: "$titulo",
      faixa: "$faixas.titulo"
    }
  }
]);

// QUESTÃO 7
db["nova coleção"].aggregate([
  { $unwind: "$faixas" },
  { $match: { "faixas.compositores": ["Roger Waters"] } },
  {
    $project: {
      _id: 0,
      album: "$titulo",
      faixa: "$faixas.titulo"
    }
  }
]);

// QUESTÃO 8
db["nova coleção"].updateMany(
  {},
  [
    {
      $set: {
        faixas: {
          $map: {
            input: "$faixas",
            as: "f",
            in: {
              $mergeObjects: [
                "$$f",
                {
                  compositores: {
                    $map: {
                      input: "$$f.compositores",
                      as: "c",
                      in: {
                        $cond: [
                          { $eq: ["$$c", "Joés"] },
                          "José",
                          "$$c"
                        ]
                      }
                    }
                  }
                }
              ]
            }
          }
        }
      }
    }
  ]
);

// QUESTÃO 9
db["nova coleção"].aggregate([
  { $unwind: "$faixas" },
  { $sort: { "faixas.duracao_segundos": -1 } },
  { $limit: 1 },
  {
    $project: {
      _id: 0,
      artista: "$artista",
      album: "$titulo",
      faixa: "$faixas.titulo",
      duracao: "$faixas.duracao_segundos"
    }
  }
]);

// QUESTÃO 10
db["nova coleção"].deleteMany({
  "faixas.compositores": "Roger Waters"
});

// QUESTÃO 11
db["nova coleção"].aggregate([
  {
    $project: {
      artista: 1,
      qtdFaixas: { $size: "$faixas" }
    }
  },
  {
    $group: {
      _id: "$artista",
      mediaFaixas: { $avg: "$qtdFaixas" },
      discos: { $sum: 1 }
    }
  }
]);

// QUESTÃO 12
const compositor = "Roger Waters";
db["nova coleção"].updateMany(
  { "faixas.compositores": compositor },
  { $pop: { faixas: 1 } }
);
