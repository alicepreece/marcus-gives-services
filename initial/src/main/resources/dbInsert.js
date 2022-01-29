// private int id;
// private String name;
// private String region;
// private String aims;
// private String fundType;
// private String strategy;
// private String avoidedAreas;
// private String managementFees;
// private List<String> investors;
// private int total;

db.projects.insertMany([
  {
    id: 0,
    name: "Alpha",
    region: "Amazon, South America",
    aims: "Counter Deforestation",
    fundType: "DAF",
    strategy: "ESG, S&P Index Fund",
    avoidedAreas: "Arms Dealing",
    managementFees: "5%",
    investors: [0, 1],
    total: 2000000,
  },
  {
    id: 1,
    name: "Beta",
    region: "West Africa, Africa",
    aims: "Accessible Education for All Primary Children",
    fundType: "DAF",
    strategy: "ESG, Globally Diversified ETF",
    avoidedAreas: "Corrupt Governments",
    managementFees: "3%",
    investors: [3],
    total: 1500000,
  },
  {
    id: 2,
    name: "Gamma",
    region: "Central Africa, Africa",
    aims: "Reduce levels in extreme poverty",
    fundType: "DAF",
    strategy: "ESG, Globally Diversified ETF",
    avoidedAreas: null,
    managementFees: "6%",
    investors: [2],
    total: 3000000,
  },
  {
    id: 3,
    name: "Delta",
    region: "South Asia, Asia",
    aims: "Reduce levels in extreme poverty",
    fundType: "DAF",
    strategy: "ESG, Globally Diversified ETF",
    avoidedAreas: null,
    managementFees: "5%",
    investors: [1, 2, 3],
    total: 1000000,
  },
]);

// private int id;
// private String firstName;
// private String surname;
// private String emailAddress;
// private int accountNumber;
// private String preferences;
// private List<Integer> projects;
// private List<Integer> pastProjects;
// private int investableAmount;

db.clients.insertMany([
  {
    id: 0,
    firstName: "Harry",
    surname: "Potter",
    emailAddress: "h.potter@gmail.com",
    accountNumber: 773354,
    preferences: "Alpha",
    projects: [0],
    pastProjects: [1],
    investableAmount: 33000
  },
  {
    id: 1,
    firstName: "Ginny",
    surname: "Potter",
    emailAddress: "g.potter@gmail.com",
    accountNumber: 773354,
    preferences: "Delta",
    projects: [0, 3],
    pastProjects: [1],
    investableAmount: 4000
  },
  {
    id: 2,
    firstName: "Hermione",
    surname: "Weasley",
    emailAddress: "h.weasley@gmail.com",
    accountNumber: 642279,
    preferences: "Beta",
    projects: [2, 3],
    pastProjects: [],
    investableAmount: 124000
  },
  {
    id: 3,
    firstName: "Ronald",
    surname: "Weasley",
    emailAddress: "r.weasley@gmail.com",
    accountNumber: 642279,
    preferences: "Alpha",
    projects: [1, 3],
    pastProjects: [],
    investableAmount: 45000
  }
])