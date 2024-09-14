import React, { useEffect, useRef, useState } from "react";
import { useDispatch, useSelector } from "../../shared/store/store";
import { Footer, Header, Main } from "./components";
import { fetchStuff } from "../../shared/store/stuff/stuffSlice";
import { metaballs } from "../../shared/utils";

// const fetchPost = async (data: Record<string, string>, endpoint: string) => {
//   try {
//     const response = await fetch(`http://localhost:9090/${endpoint}`, {
//       method: "post",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify(data),
//     });

//     if (!response.ok) {
//       throw new Error(`Error! status: ${response.status}`);
//     }

//     return await response.json();
//   } catch (error) {
//     throw new Error(`Error: not workig GET: ${error}`);
//   }
// };

// const fetchGet = async () => {
//   try {
//     const response = await fetch("http://localhost:9090/users");

//     if (!response.ok) {
//       throw new Error(`Error! status: ${response.status}`);
//     }

//     const result = await response.json();
//     console.log("get users:", result);
//   } catch (error) {
//     throw new Error(`Error: not workig GET: ${error}`);
//   }
// };

// export const Map: React.FC = () => {
//     const navigate = useNavigate();
//     const getUsers = () => {
//         fetchGet()
//     }

//     const loguout = () => {
//         fetchPost({logout: 'logout'}, 'logout')
//         navigate('/')
//     }

//     return (
//         <div>
//             <button onClick={() => {
//                 navigate('/create-user')
//             }}>
//                 create user
//             </button>
//             <button onClick={getUsers}>
//                 get table users
//             </button>
//             <button onClick={loguout}>
//                 logout
//             </button>
//         </div>
//     )
// }

// export const Map: React.FC = () => {
//     const navigate = useNavigate();
//     const [ isModal, setIsModal ] = useState(false);
//     const cnv  = useRef(null)

//     const handleModal = () => {
//         setIsModal(!isModal)
//     }

//     return(
//         <section className="w-screen h-screen flex flex-col justify-between" >
//             <header className="flex flex-row justify-between">
//                 <div className={isModal ?
//                     "absolute top-2 left-2 w-[300px] h-[300px] bg-amber-50 border rounded-xl"
//                     :
//                     "w-10 h-10 border-2 rounded-xl m-2 p-2 flex flex-col justify-around"
//                 }
//                      onClick={handleModal}
//                 >
//                     {
//                        isModal ?
//                            <div>
//                                <div>X</div>
//                                <div>
//                                    <button>Нстройки</button>
//                                    <button>Моя витрина</button>
//                                    <button>Выйти из аккаунта</button>
//                                </div>
//                            </div>
//                            :
//                            <>
//                                <div className="border-2 border-2"></div>
//                                <div className="border-2 border-2"></div>
//                                <div className="border-2 border-2"></div>
//                            </>
//                     }

//                 </div>
//                 <div className="m-2 flex flex-row items-center">
//                     <div>
//                         <input type="text" className="border rounded-3xl p-2" placeholder='поиск витрин'/>
//                     </div>
//                 </div>
//             </header>
//             <main className="h-full flex flex-col items-center justify-between w-full">
//                 <div className="w-full h-full  overflow-hidden flex gap-2">
//                     <section className="h-[100px] border flex items-center rounded-xl">
//                         <div className="w-20 h-20 m-2 border rounded-full">
//                             <img src="" alt="usm"/>
//                         </div>
//                     </section>
//                     <section className="h-[100px] border flex items-center rounded-xl">
//                         <div className="w-20 h-20 m-2 border rounded-full">
//                             <img src="" alt="usm"/>
//                         </div>
//                     </section>
//                 </div>
//                 <div className="border w-[350px] h-[500px] rounded-2xl">
//                     <div className="m-2 flex justify-around">
//                         <div className="w-10 h-10 border rounded-full flex justify-center">
//                             <button>1</button>
//                         </div>
//                         <div className="w-10 h-10 border rounded-full flex justify-center">
//                             <button>2</button>
//                         </div>
//                         <div className="w-10 h-10 border rounded-full flex justify-center">
//                             <button>3</button>
//                         </div>
//                     </div>
//                     <div className="m-2 flex justify-between items-center">
//                         <div>
//                             <button>
//                             left
//                             </button></div>
//                         <div>
//                             <canvas ref={cnv} className="border rounded-xl w-[250px] h-[400px]"></canvas>
//                         </div>
//                         <div>
//                             <button>
//                                 right
//                             </button>
//                         </div>
//                     </div>
//                 </div>
//             </main>
//             <footer>
//                 <div className="h-[150px] m-2 p-2 border-2 rounded-xl overflow-hidden flex flex-row gap-1">
//                     <section className="border w-[200px] p-2">
//                         <h1>Витрина КБТ:</h1>
//                         <p>Выстовить товар со склада</p>
//                         <time>
//                             04.08.2024
//                         </time>
//                     </section>
//                     <section className="border w-[200px] p-2">
//                         <h1>Витрина КБТ:</h1>
//                         <p>Выстовить товар со склада</p>
//                         <time>
//                             04.08.2024
//                         </time>
//                     </section>
//                 </div>
//                 <div>
//                     <span>
//                         creaty by front dima back yakov 2024
//                     </span>
//                 </div>
//             </footer>
//         </section>
//     )
// }

export const Map: React.FC = () => {
  const [isTask, setIsTask] = useState<boolean>(false);
  const [isStuff, setIsStuff] = useState<boolean>(false);
  const [isOpen, setIsOpen] = useState<boolean>(false);
  const dispatch = useDispatch();
  const canvas = useRef(null);
  const { loading, error } = useSelector((state) => state.stuff);

  useEffect(() => {
    dispatch(fetchStuff());
  }, [dispatch]);

  useEffect(() => {
    if (canvas.current) {
      metaballs(canvas.current);
    }
  }, [loading]);

  const handle = (click: string) => {
    if (click === "task") {
      setIsTask(!isTask);
      setIsStuff(false);
      setIsOpen(!isTask);
    }

    if (click === "stuff") {
      setIsStuff(!isStuff);
      setIsTask(false);
      setIsOpen(!isStuff);
    }
  };

  if (loading) {
    return <div className="text-4xl font-bold">Loading...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <section className="w-screen h-screen flex flex-col justify-between overflow-x-hidden">
      <Header isTask={isTask} isStuff={isStuff} handle={handle} />
      <Main isTask={isTask} isStuff={isStuff} />
      <Footer isOpen={isOpen} />
      <canvas
        className="h-screen w-screen absolute t-0"
        width={700}
        height={400}
        ref={canvas}
      ></canvas>
    </section>
  );
};
