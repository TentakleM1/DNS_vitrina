import React, {useRef, useState} from "react";
import { animated, useSpring } from "react-spring";

export const Map: React.FC = () => {
    const [ isModal, setIsModal ] = useState(false);
    const cnv  = useRef(null)

    const props = useSpring({
        opacity: isModal ? 1 : 0,
        config: {
            tension: 200, 
            friction: 20 
          }
    })

    const handleModal = () => {
        setIsModal(!isModal)
    }
    
    return(
        <section className="w-screen h-screen flex flex-col justify-between" >
            <header className="flex flex-row justify-between">
                <animated.div className={isModal ?
                    "absolute top-2 left-2 w-[300px] h-[300px] bg-amber-50 border rounded-xl"
                    :
                    "w-10 h-10 border-2 rounded-xl m-2 p-2 flex flex-col justify-around"
                }
                     onClick={handleModal}
                >
                    {
                       isModal ?
                           <div>
                               <div>X</div>
                               <div>
                                   <button>Нстройки</button>
                                   <button>Моя витрина</button>
                                   <button>Выйти из аккаунта</button>
                               </div>
                           </div>
                           :
                           <>
                               <div className="border-2 border-2"></div>
                               <div className="border-2 border-2"></div>
                               <div className="border-2 border-2"></div>
                           </>
                    }

                </animated.div>
                <div className="m-2 flex flex-row items-center">
                    <div>
                        <input type="text" className="border rounded-3xl p-2" placeholder='поиск витрин'/>
                    </div>
                </div>
            </header>
            <main className="h-full flex flex-col items-center justify-between w-full">
                <div className="w-full h-full  overflow-hidden flex gap-2">
                    <section className="h-[100px] border flex items-center rounded-xl">
                        <div className="w-20 h-20 m-2 border rounded-full">
                            <img src="" alt="usm"/>
                        </div>
                    </section>
                    <section className="h-[100px] border flex items-center rounded-xl">
                        <div className="w-20 h-20 m-2 border rounded-full">
                            <img src="" alt="usm"/>
                        </div>
                    </section>
                </div>
                <div className="border w-[350px] h-[500px] rounded-2xl">
                    <div className="m-2 flex justify-around">
                        <div className="w-10 h-10 border rounded-full flex justify-center">
                            <button>1</button>
                        </div>
                        <div className="w-10 h-10 border rounded-full flex justify-center">
                            <button>2</button>
                        </div>
                        <div className="w-10 h-10 border rounded-full flex justify-center">
                            <button>3</button>
                        </div>
                    </div>
                    <div className="m-2 flex justify-between items-center">
                        <div>
                            <button>
                            left
                            </button></div>
                        <div>
                            <canvas ref={cnv} className="border rounded-xl w-[250px] h-[400px]"></canvas>
                        </div>
                        <div>
                            <button>
                                right
                            </button>
                        </div>
                    </div>
                </div>
            </main>
            <footer>
                <div className="h-[150px] m-2 p-2 border-2 rounded-xl overflow-hidden flex flex-row gap-1">
                    <section className="border w-[200px] p-2">
                        <h1>Витрина КБТ:</h1>
                        <p>Выстовить товар со склада</p>
                        <time>
                            04.08.2024
                        </time>
                    </section>
                    <section className="border w-[200px] p-2">
                        <h1>Витрина КБТ:</h1>
                        <p>Выстовить товар со склада</p>
                        <time>
                            04.08.2024
                        </time>
                    </section>
                </div>
                <div>
                    <span>
                        creaty by front dima back yakov 2024
                    </span>
                </div>
            </footer>
        </section>
    )
}
