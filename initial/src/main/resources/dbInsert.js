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

// private int id;
// private String username;
// private String password;
// private String firstName;
// private String lastName;
// private RoleEnum role;
// private String authdata;


db.clients.insertMany([
  {
    id: 0,
    user: {
      username: "hpotter",
      password: "hp!password",
      firstName: "Harry",
      lastName: "Potter",
      role: "CLIENT",
    },
    emailAddress: "h.potter@gmail.com",
    accountNumber: 773354,
    recommendation: "Alpha",
    projects: [0],
    pastProjects: [1],
    investableAmount: 33000,
    advisorTeam: "Hogwarts"
  },
  {
    id: 1,
    user: {
      username: "gpotter",
      password: "gp!password",
      firstName: "Ginny",
      lastName: "Potter",
      role: "CLIENT"
    },
    emailAddress: "g.potter@gmail.com",
    accountNumber: 773354,
    recommendation: "Delta",
    projects: [0, 2],
    pastProjects: [1],
    investableAmount: 4000,
    advisorTeam: "Hogwarts"
  },
  {
    id: 2,
    user: {
      username: "hweasley",
      password: "hw!password",
      firstName: "Hermione",
      lastName: "Weasley",
      role: "CLIENT"
    },
    emailAddress: "h.weasley@gmail.com",
    accountNumber: 642279,
    recommendation: "Beta",
    projects: [1, 3],
    pastProjects: [],
    investableAmount: 124000,
    advisorTeam: "Hogwarts"
  },
  {
    id: 3,
    user: {
      username: "rweasley",
      password: "rw!password",
      firstName: "Ronald",
      lastName: "Weasley",
      role: "CLIENT"
    },
    emailAddress: "r.weasley@gmail.com",
    accountNumber: 642279,
    recommendation: "Alpha",
    projects: [2, 3],
    pastProjects: [1],
    investableAmount: 45000,
    advisorTeam: "Hogwarts"
  },
  {
    id: 4,
    user: {
      username: "fbaggins",
      password: "fb!password",
      firstName: "Frodo",
      lastName: "Baggins",
      role: "CLIENT"
    },
    emailAddress: "f.baggins@gmail.com",
    accountNumber: 992314,
    recommendation: "Gamma",
    projects: [2],
    pastProjects: [1, 3],
    investableAmount: 600000,
    advisorTeam: "Shire"
  },
  {
    id: 5,
    user: {
      username: "sgamgee",
      password: "sg!password",
      firstName: "Samwise",
      lastName: "Gamgee",
      role: "CLIENT"
    },
    emailAddress: "s.gamgee@gmail.com",
    accountNumber: 992314,
    recommendation: "Delta",
    projects: [3, 2],
    pastProjects: [1],
    investableAmount: 400000,
    advisorTeam: "Shire"
  },
  {
    id: 6,
    user: {
      username: "lpevensie",
      password: "lp!password",
      firstName: "Lucy",
      lastName: "Pevensie",
      role: "CLIENT"
    },
    emailAddress: "l.pevensie@gmail.com",
    accountNumber: 435262,
    recommendation: "Alpha",
    projects: [0],
    pastProjects: [1],
    investableAmount: 1000,
    advisorTeam: "Narnia"
  },
  {
    id: 7,
    user: {
      username: "epevensie",
      password: "ep!password",
      firstName: "Edmund",
      lastName: "Pevensie",
      role: "CLIENT"
    },
    emailAddress: "e.pevensie@gmail.com",
    accountNumber: 435262,
    recommendation: "Beta",
    projects: [1],
    pastProjects: [0],
    investableAmount: 1000,
    advisorTeam: "Narnia"
  }
])

//ADVISOR
// id
// user
// team
/*
'0': ObjectId("621342b2ffabd548cd37939a"),
'1': ObjectId("621342b2ffabd548cd37939b"),
'2': ObjectId("621342b2ffabd548cd37939c")

 */

db.advisors.insertMany([
  {
    id: 0,
    user: {
      username: "adumbledore",
      password: "ad!password",
      firstName: "Albus",
      lastName: "Dumbledore",
      role: "ADVISOR"
    },
    team: 'Hogwarts'
  },
  {
    id: 1,
    user: {
      username: "wgandalf",
      password: "wg!password",
      firstName: "Wizard",
      lastName: "Gandalf",
      role: "ADVISOR"
    },
    team: "Shire"
  },
  {
    id: 2,
    user: {
      username: "laslan",
      password: "la!password",
      firstName: "Lion",
      lastName: "Aslan",
      role: "ADVISOR"
    },
    team: "Narnia"
  }
])