import React, { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

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
  const navigate = useNavigate();
  const canvasRef = useRef<HTMLCanvasElement>(null);
  const [blocks, setBlocks] = useState({});

  const getBloks = async () => {
    try {
      const resolve = await fetch("http://localhost:9090/blocks");

      if (resolve.status === 200) {
        const result = await resolve.json();

        setBlocks(result[1]);
      }
    } catch (error) {
      console.error(`Error get bloks: ${error}`);
    }
  };

  useEffect(() => {
    const canvas = canvasRef.current;
    if (canvas) {
      const ctx = canvas.getContext("2d");
      if (ctx) {
        // getBloks()
        ctx.fillStyle = "#5490de"
        ctx.fillRect(0, 10, 30, 400)
        ctx.fillStyle = "#781f19"
        ctx.fillRect(30, 460, 570, 30)
      }
    }
  }, [blocks]);

  return (
    <section className="w-screen h-screen flex flex-col justify-between overflow-x-hidden">
      <header className="flex justify-between items-center p-6 bg-orange-400">
        <section>
          <button className="w-14">
            <img src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg" className="rounded-full" alt="" />
          </button>
        </section>
        <nav>
          <ul>
            <li className="inline-block mr-4">
              <button
                className="border rounded p-2 bg-slate-300"
                onClick={() => {
                  navigate("/create-user");
                }}
              >
                Create user
              </button>
            </li>
            <li className="inline-block  mr-4">
              <button className="border rounded p-2 bg-slate-300">
                Create task
              </button>
            </li>
            <li className="inline-block">
              <button className="border rounded p-2 bg-slate-300">
                logout
              </button>
            </li>
          </ul>
        </nav>
      </header>
      <main className="h-full flex flex-row items-center justify-around w-full gap-2">
        <div className="h-[600px] p-2 overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
          <section className="w-[300px] h-[200px] flex-none border flex rounded-xl">
            <div className="w-20 h-20 m-2">
              <img
                src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
                alt="usm"
                className="rounded-full"
              />
            </div>
          </section>
        </div>
        <div className="w-[1300px] h-[500px] border-4 rounded-xl">
          <canvas
            ref={canvasRef}
            width={1200}
            height={500}
          ></canvas>
        </div>
      </main>
      <footer>
        <div className="h-[150px] m-2 p-2 border-2 rounded-xl overflow-x-scroll overflow-y-hidden flex flex-row gap-1">
          <section className="border rounded flex-none w-[200px] p-2 cursor-pointer">
            <h1>Витрина КБТ:</h1>
            <p>Выстовить товар со склада</p>
            <time>04.08.2024</time>
          </section>
        </div>
        <div className="bg-slate-900 text-slate-300 flex justify-center">
          <span>creaty by front dima back yakov 2024</span>
        </div>
      </footer>
    </section>
  );
};
